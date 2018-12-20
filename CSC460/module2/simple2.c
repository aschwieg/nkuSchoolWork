#include <linux/init.h>
#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/slab.h>
#include <linux/list.h>

struct birthday {
	int day;
	int month;
	int year;
	struct list_head list;
};

struct birthday *ptr, *next, *person;
int i;
static LIST_HEAD(birthday_list);


/* This function is called when the module is loaded. */
int simple_init(void)
{
	pr_info("Loading Module\n");

	for (i = 0; i < 5; i++) {
		person = kmalloc(sizeof(*person), GFP_KERNEL);
		person->day = 1 + i;
		person->month = 1;
		person->year = 2000;
		INIT_LIST_HEAD(&person->list);

		list_add_tail(&person->list, &birthday_list);
	}

	list_for_each_entry(ptr, &birthday_list, list)
	{
		pr_info("Person: %d/%d/%d\n", ptr->month, ptr->day, ptr->year);
	}

	return 0;
}

/* This function is called when the module is removed. */
void simple_exit(void)
{
	pr_info("Removing Module\n");

	list_for_each_entry_safe(ptr, next, &birthday_list, list)
	{
		list_del(&ptr->list);
		kfree(ptr);
	}
}

/* Macros for registering module entry and exit points. */
module_init(simple_init);
module_exit(simple_exit);

MODULE_LICENSE("GPL");
MODULE_DESCRIPTION("Data Structures Module");
MODULE_AUTHOR("schwiegera1@mymail.nku.edu");
MODULE_VERSION("1.0");
