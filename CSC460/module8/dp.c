#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *dine();
int chopsticks[5];
pthread_mutex_t eat_mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t can_eat_cv[5];

int main(int argc, char *argv[])
{
	int i, rc;
	pthread_t philsophers[5];

	srand(time(NULL));   

	/* Initialize chopsticks */
	for (i=0; i<5; ++i)
	{
		chopsticks[i]=0;
	}

	//Initialize conditions
	for (i=0; i<5; ++i)
	{
		pthread_cond_init(&can_eat_cv[i], NULL);
	}
	
	/* Spawn threads */
	for (i=0; i<5; ++i)
	{
		if( (rc=pthread_create( &philsophers[i], NULL, &dine, &i)) )
			printf("Thread creation failed: %d\n", rc);
		sleep(1);
	}

	/* Wait for thread completion */
	for (i=0; i<5; ++i)
		pthread_join( philsophers[i], NULL);

	exit(0);
}

think(int pnum)
{
	int r = (rand() % 10) + 1;
	printf("Philosopher %d is thinking for %d seconds\n", pnum, r);
	sleep(r);
}

eat(int pnum)
{
	int r = (rand() % 10) + 1;
	printf("Philosopher %d is hungry\n", pnum);

	pthread_mutex_lock(&eat_mutex);
	while (chopsticks[pnum] == 1 || chopsticks[(pnum + 1) % 5] == 1) {
		pthread_cond_wait(&can_eat_cv[pnum], &eat_mutex);
	}
	chopsticks[pnum] = 1;
	chopsticks[(pnum + 1) % 5] = 1;
	pthread_mutex_unlock(&eat_mutex);

	printf("Philosopher %d is eating for %d seconds\n", pnum, r);
	sleep(r);

	pthread_mutex_lock(&eat_mutex);
	chopsticks[pnum] = 0;
	chopsticks[(pnum + 1) % 5] = 0;
	pthread_mutex_unlock(&eat_mutex);
	pthread_cond_signal(&can_eat_cv[(pnum-1) % 5]);
	pthread_cond_signal(&can_eat_cv[(pnum+1) % 5]);
}

void *dine(void *pnum_ptr)
{
	int pnum = *(int*)pnum_ptr;

	printf("Created philosopher thread %d\n", pnum);

	while (1)
	{
		think(pnum);
		eat(pnum);
	}
}
