package fr.epita.assistants.notifyme.notify;

public class ShellNotifier implements INotificationSender{

    public boolean parStdErr;
    /**
     * Constructor
     * @param parStdErr if true, print to stderr, otherwise print to stdout
     */
    public ShellNotifier(final boolean parStdErr){
        this.parStdErr = parStdErr;
    }

    @Override
    public void notify(String parSender, String parReceiver, String parMessage) {
        String msg = "Notification from " + parSender + " to " + parReceiver + " received: " + parMessage;
        if (parStdErr){
            System.err.println(msg);
        }else {
            System.out.println(msg);
        }
    }
}
