import java.util.LinkedList


class Piece(var xp: Int, var yp: Int, var isWhite: Boolean, var ps: LinkedList[Piece]) {



  ps.add(this)

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
  }
}