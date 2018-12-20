/*
  File Name: Proj6_Client.cpp
  Author: Alex Schwiegeraht
  Course: CSC 402
  Date: 12/13/2018
*/

#define _CRT_SECURE_NO_WARNINGS

#define WIN32_LEAN_AND_MEAN

#include <windows.h>
#include <winsock2.h>
#include <ws2tcpip.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <iostream>

// Need to link with Ws2_32.lib, Mswsock.lib, and Advapi32.lib
#pragma comment (lib, "Ws2_32.lib")
#pragma comment (lib, "Mswsock.lib")
#pragma comment (lib, "AdvApi32.lib")


#define DEFAULT_BUFLEN 512
#define DEFAULT_PORT "27016"

int __cdecl main(int argc, char **argv)
{
	WSADATA wsaData;
	SOCKET ConnectSocket = INVALID_SOCKET;
	struct addrinfo *result = NULL,
		*ptr = NULL,
		hints;

	// char *sendbuf = "this is a test";   //  disallowed with /permissive- flag
	char *sendbuf = new char[strlen("this is a test")];

	char recvbuf[DEFAULT_BUFLEN];
	int iResult, quit = 1;
	int recvbuflen = DEFAULT_BUFLEN;

	// Validate the parameters
	/*if (argc != 2) {
		printf("usage: %s server-name\n", argv[0]);
		return 1;
	}*/

	// Initialize Winsock
	iResult = WSAStartup(MAKEWORD(2, 2), &wsaData);
	if (iResult != 0) {
		printf("WSAStartup failed with error: %d\n", iResult);
		return 2;
	}

	ZeroMemory(&hints, sizeof(hints));
	hints.ai_family = AF_UNSPEC;
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_protocol = IPPROTO_TCP;

	// Resolve the server address and port
	iResult = getaddrinfo(argv[1], DEFAULT_PORT, &hints, &result);
	if (iResult != 0) {
		printf("getaddrinfo failed with error: %d\n", iResult);
		WSACleanup();
		return 3;
	}

	// Attempt to connect to an address until one succeeds
	for (ptr = result; ptr != NULL; ptr = ptr->ai_next) {

		// Create a SOCKET for connecting to server
		ConnectSocket = socket(ptr->ai_family, ptr->ai_socktype,
			ptr->ai_protocol);
		if (ConnectSocket == INVALID_SOCKET) {
			printf("socket failed with error: %ld\n", WSAGetLastError());
			WSACleanup();
			return 4;
		}

		// Connect to server.
		iResult = connect(ConnectSocket, ptr->ai_addr, (int)ptr->ai_addrlen);
		if (iResult == SOCKET_ERROR) {
			closesocket(ConnectSocket);
			ConnectSocket = INVALID_SOCKET;
			continue;
		}
		break;
	}

	freeaddrinfo(result);

	if (ConnectSocket == INVALID_SOCKET) {
		printf("Unable to connect to server!\n");
		WSACleanup();
		return 5;
	}

	// Receive until the client closes the connection by sending quit
	do {
		std::cout << "In the client ready to send a command..." << std::endl;
		std::cin >> sendbuf;

		iResult = send(ConnectSocket, sendbuf, (int)strlen(sendbuf), 0);
		std::cout << "Command sent: " << sendbuf << std::endl;

		if (iResult == SOCKET_ERROR) {
			printf("send failed with error: %d\n", WSAGetLastError());
			closesocket(ConnectSocket);
			WSACleanup();
			return 1;
		}

		iResult = recv(ConnectSocket, recvbuf, recvbuflen, 0);
		recvbuf[iResult] = '\0';

		if (iResult == 0) {
			quit = 0;
			printf("Connection closed\n");
		}
		else {
			std::cout << "Message recieved from server" << std::endl;
			std::cout << "Server Response: "<< recvbuf << std::endl;

		}

		//Verifies the server has ended
		if (strcmp(recvbuf, "quit command confirmed") == 0)
			quit = 0;

	} while (quit);


	// shutdown the connection since no more data will be sent
	iResult = shutdown(ConnectSocket, SD_SEND);
	if (iResult == SOCKET_ERROR) {
		printf("shutdown failed with error: %d\n", WSAGetLastError());
		closesocket(ConnectSocket);
		WSACleanup();
		return 6;
	}

	// cleanup
	closesocket(ConnectSocket);
	WSACleanup();
	
	std::cin.get();

	return 0;
}