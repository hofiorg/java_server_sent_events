package org.hofi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Server extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    //content type must be set to text/event-stream
    response.setContentType("text/event-stream");

    //encoding must be set to UTF-8
    response.setCharacterEncoding("UTF-8");

    PrintWriter writer = response.getWriter();

    for(int i=0; i<10; i++) {

      long time = System.currentTimeMillis();
      System.err.println("data: " + time);
      writer.write("data: "+ time +"\n\n");

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    writer.close();
  }

}
