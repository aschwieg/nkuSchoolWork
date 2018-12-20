#include <linux/init.h>
#include <linux/module.h>
#include <linux/kernel.h>

/* This function is called when the module is loaded. */
int simple_init(void)
{
	pr_info("Loading Module\n");

	return 0;
}

/* This function is called when the module is removed. */
void simple_exit(void)
{
	pr_info("Removing Module\n");
}

/* Macros for registering module entry and exit points. */
module_init(simple_init);
module_exit(simple_exit);

MODULE_LICENSE("GPL");
MODULE_DESCRIPTION("Simple Module");
MODULE_AUTHOR("schwiegera1@mymail.nku.edu");
MODULE_VERSION("1.0");