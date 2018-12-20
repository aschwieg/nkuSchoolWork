#include <linux/init.h>
#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/sched.h>
#include <linux/sched/signal.h>

struct task_struct *task;

/* This function is called when the module is loaded. */
int list_init(void)
{
	pr_info("Loading Module\n");

for_each_process(task)
{
pr_info("%d\t%ld\t%s\n", task_pid_nr(task), task->state, task->comm);
}
	return 0;
}

/* This function is called when the module is removed. */
void list_exit(void)
{
	pr_info("Removing Module\n");
}

/* Macros for registering module entry and exit points. */
module_init(list_init);
module_exit(list_exit);

MODULE_LICENSE("GPL");
MODULE_DESCRIPTION("Listing Tasks Module");
MODULE_AUTHOR("schwiegera1@mymail.nku.edu");
MODULE_VERSION("1.0");
