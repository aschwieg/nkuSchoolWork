#include <stdio.h>
#include <unistd.h>
#include <string.h>

#define MAX_LINE 80

int main(void)
{
    char *args[MAX_LINE/2 + 1];

    char command[81];
    int should_run = 1, i, f, should_wait;
    pid_t pid;

    while (should_run) 
    {
        should_wait = 1;
        i = 0;
        printf("osh>");
        fgets(command,81,stdin);

        command[strlen(command) - 1] = '\0';

        char *p = strtok (command, " ");

        if(strcmp(p,"exit") == 0)
        {
            should_run = 0;
        }
        else
        {
            while (p)
            {   
                if(strcmp(p,"&") == 0)
                {
                    should_wait = 0;
                }

                args[i] = p;

                i++;
                p = strtok (NULL, " ");
            }

            pid = fork();
            if(pid == 0)
            {
                execvp(args[0],args);
            }
            else
            {
                if(should_wait == 1){
                    wait(); 
                }
            }
        }
    }
    return 0;
}