/*
  File Name: Proj6_Server.cpp
  Author: Alex Schwiegeraht
  Course: CSC 402
  Date: 12/13/2018
*/

#undef UNICODE
#define _CRT_SECURE_NO_WARNINGS
#define WIN32_LEAN_AND_MEAN

#include <windows.h>
#include <winsock2.h>
#include <ws2tcpip.h>
#include <stdlib.h>
#include <stdio.h>
#include <iostream>
#include <string>

using namespace std;

// Need to link with Ws2_32.lib
#pragma comment (lib, "Ws2_32.lib")

#define DEFAULT_BUFLEN 512
#define DEFAULT_PORT "27016"

int __cdecl main(void)
{
	WSADATA wsaData;
	int iResult;

	SOCKET ListenSocket = INVALID_SOCKET;
	SOCKET ClientSocket = INVALID_SOCKET;

	struct addrinfo *result = NULL;
	struct addrinfo hints;

	int iSendResult, quit = 1;
	char recvbuf[DEFAULT_BUFLEN];
	int recvbuflen = DEFAULT_BUFLEN;

	// Initialize Winsock
	iResult = WSAStartup(MAKEWORD(2, 2), &wsaData);
	if (iResult != 0) {
		printf("WSAStartup failed with error: %d\n", iResult);
		return 1;
	}

	ZeroMemory(&hints, sizeof(hints));
	hints.ai_family = AF_INET;
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_protocol = IPPROTO_TCP;
	hints.ai_flags = AI_PASSIVE;

	// Resolve the server address and port
	iResult = getaddrinfo(0, DEFAULT_PORT, &hints, &result);
	if (iResult != 0) {
		printf("getaddrinfo failed with error: %d\n", iResult);
		WSACleanup();
		return 1;
	}

	// Create a SOCKET for connecting to server
	ListenSocket = socket(result->ai_family, result->ai_socktype, result->ai_protocol);
	if (ListenSocket == INVALID_SOCKET) {
		printf("socket failed with error: %ld\n", WSAGetLastError());
		freeaddrinfo(result);
		WSACleanup();
		return 1;
	}

	cout << "Server Starting..." << endl;
	// Setup the TCP listening socket
	iResult = ::bind(ListenSocket, result->ai_addr, (int)result->ai_addrlen);
	if (iResult == SOCKET_ERROR) {
		printf("bind failed with error: %d\n", WSAGetLastError());
		freeaddrinfo(result);
		closesocket(ListenSocket);
		WSACleanup();
		return 1;
	}

	freeaddrinfo(result);

	iResult = listen(ListenSocket, SOMAXCONN);
	if (iResult == SOCKET_ERROR) {
		printf("listen failed with error: %d\n", WSAGetLastError());
		closesocket(ListenSocket);
		WSACleanup();
		return 1;
	}

	cout << "Waiting for clients..." << endl;
	// Accept a client socket
	ClientSocket = accept(ListenSocket, NULL, NULL);
	if (ClientSocket == INVALID_SOCKET) {
		printf("accept failed with error: %d\n", WSAGetLastError());
		closesocket(ListenSocket);
		WSACleanup();
		return 1;
	}

	// No longer need server socket
	closesocket(ListenSocket);

	// Receive until the peer shuts down the connection by sending quit
	do {
		cout << "In the server loop ready to receive a command..." << endl;

		iResult = recv(ClientSocket, recvbuf, recvbuflen, 0);
		recvbuf[iResult] = '\0';

		if (iResult > 0) {
			
			cout << "Received command: " << recvbuf << endl;

			if ((strcmp(recvbuf, "move") == 0) || (strcmp(recvbuf, "shoot") == 0) || (strcmp(recvbuf, "stats") == 0) || (strcmp(recvbuf, "quit") == 0)) {
				cout << recvbuf << " command recieved" << endl;
				strcat(recvbuf, " command confirmed");
			}
			else if (strcmp(recvbuf, "help") == 0) {
				cout << recvbuf << " command recieved" << endl;
				strcpy(recvbuf, "Valid commands are 'move', 'shoot', 'stats', and 'quit'");
			}
			else {
				cout << "Unrecognized command received:" << recvbuf << endl;
				strcpy(recvbuf, "Unrecognized command; send the help command for usage information.");
			}

			// Echo the buffer back to the sender
			iSendResult = send(ClientSocket, recvbuf, (int)strlen(recvbuf), 0);

			if (iSendResult == SOCKET_ERROR) {
				printf("send failed with error: %d\n", WSAGetLastError());
				closesocket(ClientSocket);
				WSACleanup();
				return 1;
			}

			if (strcmp(recvbuf, "quit command confirmed") == 0)
				quit = 0;

		}
		else if (iResult == 0) {
			printf("Connection closing...\n");
			quit = 0;
		}
			
		else {
			printf("recv failed with error: %d\n", WSAGetLastError());
			closesocket(ClientSocket);
			WSACleanup();
			return 1;
		}

		if (strcmp(recvbuf, "quit") == 0)
			quit = 0;

	} while (quit);

	// shutdown the connection since we're done
	iResult = shutdown(ClientSocket, SD_SEND);
	if (iResult == SOCKET_ERROR) {
		printf("shutdown failed with error: %d\n", WSAGetLastError());
		closesocket(ClientSocket);
		WSACleanup();
		return 1;
	}

	// cleanup
	closesocket(ClientSocket);
	WSACleanup();

	return 0;
} 