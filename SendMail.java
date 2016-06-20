public class SendMail extends javax.swing.JFrame {

  /**
   * The constructor. Do all basic setup for this application.
   */
  public SendMail() {
    //{{INIT_CONTROLS
    setTitle("SendMail Example");
    getContentPane().setLayout(null);
    setSize(736, 312);
    setVisible(false);
    JLabel1.setText("From:");
    getContentPane().add(JLabel1);
    JLabel1.setBounds(12, 12, 36, 12);
    JLabel2.setText("To:");
    getContentPane().add(JLabel2);
    JLabel2.setBounds(12, 48, 36, 12);
    JLabel3.setText("Subject:");
    getContentPane().add(JLabel3);
    JLabel3.setBounds(12, 84, 48, 12);
    JLabel4.setText("SMTP Server:");
    getContentPane().add(JLabel4);
    JLabel4.setBounds(12, 120, 84, 12);
    getContentPane().add(_from);
    _from.setBounds(96, 12, 300, 24);
    getContentPane().add(_to);
    _to.setBounds(96, 48, 300, 24);
    getContentPane().add(_subject);
    _subject.setBounds(96, 84, 300, 24);
    getContentPane().add(_smtp);
    _smtp.setBounds(96, 120, 300, 24);
    getContentPane().add(_scrollPane2);
    _scrollPane2.setBounds(12, 156, 384, 108);
    _body.setText("Enter your message here.");
    _scrollPane2.getViewport().add(_body);
    _body.setBounds(0, 0, 381, 105);
    Send.setText("Send");
    Send.setActionCommand("Send");
    getContentPane().add(Send);
    Send.setBounds(60, 276, 132, 24);
    Cancel.setText("Cancel");
    Cancel.setActionCommand("Cancel");
    getContentPane().add(Cancel);
    Cancel.setBounds(216, 276, 120, 24);
    getContentPane().add(_scrollPane);
    _scrollPane.setBounds(408, 12, 312, 288);
    getContentPane().add(_output);
    _output.setBounds(408, 12, 309, 285);
    //}}

    //{{INIT_MENUS
    //}}

    //{{REGISTER_LISTENERS
    SymAction lSymAction = new SymAction();
    Send.addActionListener(lSymAction);
    Cancel.addActionListener(lSymAction);
    //}}

    _output.setModel(_model);
    _model.addElement("Server output displayed here:");
    _scrollPane.getViewport().setView(_output);
    _scrollPane2.getViewport().setView(_body);
  }

   public void setVisible(boolean b) {
    if (b)
      setLocation(50, 50);
    super.setVisible(b);
  }
static public void main(String args[]) {
    (new SendMail()).show();
  }
