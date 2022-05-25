import java.awt.{BorderLayout, EventQueue, Font, Panel}
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.{JButton, JComponent, JFrame, JLabel, JTextField}
import javax.xml.crypto.Data


@SerialVersionUID(1L)
object Main {
  def main(args: Array[String]): Unit = {
    EventQueue.invokeLater(new Runnable() {
      override def run(): Unit = {
        try {
          val view = new Main
          view.setVisible(true)
        } catch {
          case e: Exception =>
            e.printStackTrace()
        }
      }
    })
  }
}

@SerialVersionUID(1L)
class Main() extends JFrame {
  initialize()
  private var main_label = null
  private var input_field = null
  private var enter = null

  private def initialize(): Unit = {
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE)
    setBounds(400, 200, 600, 250)
    setTitle("Triple Game Engine")
    setLayout(null)
    setResizable(false)
    def display(pane: JComponent): Unit = synchronized {
      setLayout(new BorderLayout())
      getContentPane.removeAll()
      add(pane, BorderLayout.CENTER)
      pack()
      setVisible(true)
    }


    /*  main_label.setBounds(50, 20, 500, 40)
      input_field = new JTextField
      input_field.setBounds(100, 80, 400, 50)
      enter = new JButton("enter")
      enter.setBounds(200, 180, 200, 50)
      final def ActionListener(f: (ActionEvent) ⇒ Unit): ActionListener
      enter.addActionListener(new ActionListener() {
        override def actionPerformed(arg0: ActionEvent): Unit = {
          if (Valid.isValidInt(input_field.getText)) {
            val n = input_field.getText.toInt
            Data.numOfNodes = n
            Data.segmentsGains = new Array[Array[Double]](n, n)
            val view = new Panel
            view.setVisible(true)
            dispose()
          }
        }
      })

      getContentPane.add(main_label)
      getContentPane.add(input_field)
      getContentPane.add(enter)
    }*/}
}