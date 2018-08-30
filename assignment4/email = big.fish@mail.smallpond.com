email = big.fish@mail.smallpond.com

a = email.indexof("@");
mailbox = email.substring(0,a);
mailserver = email.substring(a+1)

int last = mailserver.lastindexof(".");
String temp = mailserver.substring(0,last);
int slast = temp.lastindexof(".");
domain = mailserver.substring(slast+1)