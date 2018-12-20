#include <stdio.h>
#include <pthread.h>
#include <time.h>
#include <stdlib.h>

#define MIN_PID 300
#define MAX_PID 5000

int allocate_map(void);
int allocate_pid(void);
void release_pid(int);
void *pidThread(void *);

int pid_map[MAX_PID];
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

int main(int argc, char *argv[])
{
    pthread_t *tptr;
    int numthreads, i, rc;

    if (argc > 1)
		numthreads = atoi(argv[1]);
	else
		numthreads = 2;

    tptr = malloc(sizeof(pthread_t) * numthreads);

    srand(time(NULL));

    allocate_map();
    for (i = 0; i < numthreads; i++) {
        rc = pthread_create(tptr+i, NULL, pidThread, NULL);
		if (rc)
			printf("Thread creation failed with rc = %d\n", rc);
    }

    for (i=0; i < numthreads; i++)
		pthread_join(*(tptr+i), NULL);

    free(tptr);
    return 1;
}

//set all pids to 0 to free them up
int allocate_map(void)
{  
    int i;

    //sets all 5000 to zero even though the first 300 are reserved
    for(i = 0; i < MAX_PID; i++) {
        pid_map[i] = 0;
    }
    return 1;
}

//allocate a pid by going through the array until an empty spot is found
int allocate_pid(void)
{
    int i = MIN_PID;
    int pid = 0;
    while(pid == 0 || i < MAX_PID) {
        if (pid_map[i] == 0){
            pthread_mutex_lock(&mutex);
            pid_map[i] = 1;
            pthread_mutex_unlock(&mutex);
            pid = i;
            printf("Allocated %d\n", pid);
            return pid;
        }
        
        i++;
    }
    return 1;
}

//Takes the given pid and get its true position and free it up for use again
void release_pid(int pid)
{
    pthread_mutex_lock(&mutex);
    pid_map[pid] = 0;
    pthread_mutex_unlock(&mutex);
    printf("Released %d\n", pid);
}

//Thread allocates a PID, "does some work", then releases the PID
void *pidThread(void *param) 
{
    int r = (rand() % 9) + 2;
    int pid;
    pid = allocate_pid();
    sleep(r);
    release_pid(pid);
    pthread_exit(0);
}