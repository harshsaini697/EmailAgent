 class SymAction implements java.awt.event.ActionListener {

    /**
     * Route the event to the correction method.
     * 
     * @param event
     *            The event.
     */
    public void actionPerformed(java.awt.event.ActionEvent event) {
      Object object = event.getSource();
      if (object == Send)
        Send_actionPerformed(event);
      else if (object == Cancel)
        Cancel_actionPerformed(event);
    }
  }
 protected void send(String s) throws java.io.IOException {
    // Send the SMTP command
    if (s != null) {
      _model.addElement("C:" + s);
      _out.println(s);
      _out.flush();
    }
    // Wait for the response
    String line = _in.readLine();
    if (line != null) {
      _model.addElement("S:" + line);
    }
  }

void Send_actionPerformed(java.awt.event.ActionEvent event) {
    try {

      java.net.Socket s = new java.net.Socket(_smtp.getText(), 25);
      _out = new java.io.PrintWriter(s.getOutputStream());
      _in = new java.io.BufferedReader(new java.io.InputStreamReader(s
          .getInputStream()));

      send(null);
      send("HELO " + java.net.InetAddress.getLocalHost().getHostName());
      send("MAIL FROM: " + _from.getText());
      send("RCPT TO: " + _to.getText());
      send("DATA");
      _out.println("Subject:" + _subject.getText());
      _out.println(_body.getText());
      send(".");
      s.close();

    } catch (Exception e) {
      _model.addElement("Error: " + e);
    }

  }
