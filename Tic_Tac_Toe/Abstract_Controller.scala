package TTT

trait Abstract_Controller {
  def valid_input(in: String): Boolean
  def InputToIndex(in: String):Array[Int]
  def valid_cell(index: Array[Int]): Boolean
}
