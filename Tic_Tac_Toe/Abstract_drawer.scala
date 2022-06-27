package TTT

trait Abstract_drawer {
  def draw_X_O(turn: Int, i: Int, j: Int): Unit
  def drawBox(): Unit
  def drawFrame(): Unit
}
