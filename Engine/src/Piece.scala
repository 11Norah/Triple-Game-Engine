import java.util
import java.util.LinkedList


 class Piece() {
  //var ps: util.ArrayList[Piece]
  private var isWhite :Boolean =true //true if light grey (player2),false dark grey (player1)
  private var xp:Int=0
  private var yp:Int=0
   private var CharPos:String=null
   private var IntPos: Int=0
   def setchar(ch:String): Unit ={
     this.CharPos=ch
   }
   def getchar(): Unit ={
     return this.CharPos
   }
   def setInt(ch:Int): Unit ={
     this.IntPos=ch
   }
   def getInt(): Unit ={
     return this.IntPos
   }

  def setisWhite( colour:Boolean): Unit ={
    this.isWhite=colour
  }

  def getisWhite: Boolean = {
    return this.isWhite
  }
  def setX( xposition:Int): Unit ={
    this.xp=xposition
  }
  def getX(): Int ={
    return this.xp
  }
  def setY( yposition:Int): Unit ={
    this.yp=yposition
  }
  def getY(): Int ={
    return this.yp
  }
  /*ps.add(this)

  def move(xp: Int, yp: Int): Unit = {
    ps.stream.filter((p: Piece) => p.xp == xp && p.yp == yp).forEachOrdered((p: Piece) => {
      def foo(p: Piece) = {
        p.kill()
      }

      foo(p)
    })
    this.xp = xp
    this.yp = yp
  }

  def kill(): Unit = {
    ps.remove(this)
  }*/
}