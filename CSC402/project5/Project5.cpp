/*
  File Name: Project5.cpp
  Author: Alex Schwiegeraht
  Course: CSC 402
  Date: 11/30/2018
*/

#include <string>
#include <iostream>
#include <map>
#include <fstream>
#include <sstream>
#include <iomanip>

using namespace std;

struct ItemInfo {
	string description;
	double unitPrice;
	double shippingWeight;
	ItemInfo(string desc = " ", double up = 0, double sw = 0) : description{ desc }, unitPrice{ up }, shippingWeight{ sw } {};
};

typedef map<string, ItemInfo> Catalog;
typedef map<string, int> Order;

void readCatalog(Catalog&, const string&) throw (runtime_error);
void printCatalog(const Catalog&);
ItemInfo getItemData(const Catalog&, const string&);
void displayOrderItems(const Order&, const Catalog&);
void addItem(Order&, const Catalog&, const string&, int) throw (logic_error);
void removeItem(Order&, const string&, int) throw (logic_error);
void displayOrderSummary(const Order&, const Catalog&);

int main()
{
	// construct default Order and Catalog
	Catalog catalog;
	Order order;
	ItemInfo i1, i2, i3;

	// test readCatalog exception handling by trying to open a non-existent file
	try
	{
		readCatalog(catalog, "daksfjblkdsbj.txt");
	}
	catch (runtime_error &e)
	{
		cout << "Exception caught: " << e.what() << endl;
	}
		

	// open CatalogData.txt by calling readCatalog which populates the Catalog map 
	try
	{
		readCatalog(catalog, "CatalogData.txt");
	}
	catch (runtime_error &e)
	{
		cout << "Exception caught: " << e.what() << endl;
	}



	// print out the entire catalog
	printCatalog(catalog);
	cout << endl;
	// search for a few specific catalog items by SKU, some found, 
	// and at least one that cannot be found
	catalog.find("4123BLU");
	catalog.find("4123BLA");
	catalog.find("adfdvljkbDVSLbdB");

	// print out the details of few items using getItemData
	i1 = getItemData(catalog, "4123BLU");
	i2 = getItemData(catalog, "4123BLA");

	cout << "i1: " << i1.description << "\t" << i1.unitPrice << "\t" << i1.shippingWeight << endl <<
		"i2: " << i2.description << "\t" << i2.unitPrice << "\t" << i2.shippingWeight << endl << endl;
	cout << endl;

	// Add several items to the order
	addItem(order, catalog, "4123BLU", 3);
	addItem(order, catalog, "4123BLA", 3);
	addItem(order, catalog, "4123BLU", 2);

	// display items in the order
	displayOrderItems(order, catalog);
	cout << endl;

	// remove item(s) such that no item is completely removed
	removeItem(order, "4123BLU", 4);
	removeItem(order, "4123BLA", 2);

	// display items in the order to verify quantities
	displayOrderItems(order, catalog);
	cout << endl;

	// try to remove an item that is not in the order to test exception handling
	try {
		removeItem(order, "adsgkljSDBLK", 4);
	}
	catch (logic_error) {
		cout << "Error: Item not found" << endl;
	}

	// remove all of at least one item to make sure the order no longer shows it
	removeItem(order, "4123BLA", 1);

	// display items in the order
	displayOrderItems(order, catalog);
	cout << endl;

	// display order summary
	displayOrderSummary(order, catalog);


	// portable pause
	cin.get();
	return 0;
}

// reads the input file and creates the catalog; throws a runtime_error if the file cannot be opened
void readCatalog(Catalog& catalog, const string& fileName) throw (runtime_error)
{
	string tokens[4];
	string tmp, line, sku;
	ifstream inFile;
	ItemInfo tempItem;
	istringstream ss;
	int i = 0;

	inFile.open(fileName);

	if(!inFile.is_open())
		throw runtime_error("File Failed to open");

	while (getline(inFile, line))
	{
		ss.str(line);

		while (getline(ss, tmp, ':')) {
			tokens[i] = tmp;
			i++;
		}

		sku = tokens[0];
		tempItem.description = tokens[1];
		tempItem.unitPrice = stod(tokens[2]);
		tempItem.shippingWeight = stod(tokens[3]);
		catalog.insert(pair<string, ItemInfo>(sku, tempItem));

		ss.clear();
		i = 0;
	}
	inFile.close();
}

// prints the SKU, description, price, and weight of every item in the catalog 
void printCatalog(const Catalog& catalog)
{	
	cout << setfill(' ') << setw(10) << left << "SKU" <<
		setfill(' ') << setw(60) << left << "Description" <<
		setfill(' ') << setw(10) << left << "Price" <<
		setfill(' ') << setw(10) << left << "Weight" <<
		endl << "========================================================================================" << endl;

	for (Catalog::const_iterator it = catalog.begin(); it != catalog.end(); ++it)
		cout << 
		setfill(' ') << setw(10) << left << it->first <<
		setfill(' ') << setw(60) << left << it->second.description << 
		setfill(' ') << setw(10) << left << it->second.unitPrice <<
		setfill(' ') << setw(10) << left << it->second.shippingWeight << 
		endl;
}

// finds a single item by SKU and returns the details as a struct;
// returns a dummy struct with the description "Item not found", 
// price 0.00, and weight 0.00 if the SKU is not in the catalog
ItemInfo getItemData(const Catalog& catalog, const string& sku)
{
	ItemInfo itemData;
	Catalog::const_iterator it;

	it = catalog.find(sku);
	
	if (it == catalog.end())
		itemData.description = "Item not found";
	else
		itemData = it->second;

	return itemData;
}

// Lists the SKU, description, and quantity of each type of order item
void displayOrderItems(const Order& order, const Catalog& catalog)
{
	cout << setfill(' ') << setw(10) << left << "SKU" <<
		setfill(' ') << setw(60) << left << "Description" <<
		setfill(' ') << setw(10) << left << "Quantity" <<
		endl << "========================================================================================" << endl;

	for (Order::const_iterator it = order.begin(); it != order.end(); ++it)
		cout <<
			setfill(' ') << setw(10) << left << it->first <<
			setfill(' ') << setw(60) << left << getItemData(catalog, it->first).description <<
			setfill(' ') << setw(10) << left << it->second <<
			endl;
}

// adds item(s) to the order; throws a logic_error if the item cannot be found in the catalog
void addItem(Order& order, const Catalog& catalog, const string& sku, int quantity) throw (logic_error)
{
	ItemInfo itemData;
	Catalog::const_iterator cit;
	Order::iterator oit;

	cit = catalog.find(sku);

	if (cit == catalog.end())
		throw logic_error("Item not found.");
	
	oit = order.find(sku);

	if (oit == order.end())
		order.insert(pair<string, int>(sku, quantity));
	else
		oit->second += quantity;
}

// removes items(s) from the order; throws a logic_error if the item cannot be found in the order 
void removeItem(Order& order, const string& sku, int quantity) throw (logic_error)
{
	ItemInfo itemData;
	Order::iterator oit;

	oit = order.find(sku);

	if (oit == order.end())
		throw logic_error("Order not found.");
	else {
		if (quantity >= oit->second)
			order.erase(oit);
		else
			oit->second -= quantity;
	}
}

// displays the number of unique item types, the total number of items, the total cost, and the total shipping weight 
void displayOrderSummary(const Order& order, const Catalog& catalog)
{
	int distinct = order.size(), quantity;
	double totalItems = 0, totalCost = 0, totalWeight = 0;
	ItemInfo temp;

	for (Order::const_iterator it = order.begin(); it != order.end(); ++it) 
	{
		quantity = it->second;
		temp = getItemData(catalog, it->first);
		totalCost += (temp.unitPrice * quantity);
		totalWeight += (temp.shippingWeight * quantity);
		totalItems += quantity;
	}
		
	cout << "Order Summary" <<
		endl << "========================================================================================" << endl <<
		"Distinct item types: " << distinct << endl <<
		"Total number of items: " << totalItems << endl <<
		"Total cost: " << totalCost << endl <<
		"Total weight: " << totalWeight << endl <<
		 endl;
}