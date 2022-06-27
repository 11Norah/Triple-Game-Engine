package Chess

class Controller_Chess(var lock_1: Boolean, var lock_2: Boolean, board: Drawer_Chess) {

  var TurnCapital = true

  def player1 = {
    print("\nPLAYER 1 - Big Case\n")
    print("\nEnter Position of Element to change and the position sent to: ")
    val Position = scala.io.StdIn.readLine()
    var Position1 = Position.split(' ')
    var Active = new Square(Position1(0), board)
    var Target = new Square(Position1(1), board)
    val piece = board.returnsquare(Active.Row, Active.Col)
    // if (!lock_1) {
    piece match {
      case 'P' => TurnCapital = !board.pawn.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case 'R' => TurnCapital = !board.rook.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case 'N' => TurnCapital = !board.knight.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case 'B' => TurnCapital = !board.bishop.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case 'K' => TurnCapital = !board.king.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case 'Q' => TurnCapital = !board.queen.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case _ =>
        TurnCapital = true
        println("Invalid Move ! ")
    }
    if (TurnCapital && piece !='K') println("-position is invalid-")
    else move(Active.Row, Active.Col, Target.Row, Target.Col, !TurnCapital)

  }

  def player2(): Unit = {
    print("\nPLAYER 2 - Small Case\n")
    print("\nEnter Position of Element to change and the position sent to: ")
    var Position = scala.io.StdIn.readLine()
    var Position1 = Position.split(' ')
    var Active = new Square(Position1(0), board)
    var Target = new Square(Position1(1), board)
    // if (!lock_2) {
    board.returnsquare((Active.Row), (Active.Col)) match {
      case 'p' => TurnCapital = board.pawn.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case 'r' => TurnCapital = board.rook.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case 'n' => TurnCapital = board.knight.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case 'b' => TurnCapital = board.bishop.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case 'k' => TurnCapital = board.king.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case 'q' => TurnCapital = board.queen.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
      case _ =>
        TurnCapital = false
        println("Invalid Move ! ")

    }
    if (!TurnCapital) println("-position is invalid-")
    else if (TurnCapital && board.board(Active.Row)(Active.Col) != 'k') {
      move(Active.Row, Active.Col, Target.Row, Target.Col, TurnCapital)
    }
    // }
    /* else {
       if (board.returnsquare(Active.Row, Active.Col) != 'k') {
         TurnCapital = false
         println("King is still in danger, MOVE IT!!! ")
       }
       else {
         TurnCapital = board.king.validmoves(Active.Row, Active.Col, Target.Row, Target.Col)
         if(TurnCapital) lock_2 = false
       }
     }

     if (check_king(board.king.track_pos_white(0), board.king.track_pos_white(1))==1) {
       println("White King is Endangered!!!")
       lock_1 = true
     }*/
  }

  ////check king
  def check(activeRow: Int, activeCol: Int, targetRow: Int, targetCol: Int): Int = {
   //return true must change king only other than that change any piece 3dy/
    if ((board.pawn.validmoves(activeRow, activeCol, targetRow, targetCol)
      /*|| board.rook.validmoves(activeRow, activeCol, targetRow, targetCol)*/
      || board.knight.validmoves(activeRow, activeCol, targetRow, targetCol)
    /*  || board.bishop.validmoves(activeRow, activeCol, targetRow, targetCol)*/
    /* || board.queen.validmoves(activeRow, activeCol, targetRow, targetCol))*/)) {
      if (board.returncolor(targetRow, targetCol)) return 0 //black
      else if (!board.returncolor(targetRow, targetCol)) return 1 //white
    }
    return -1 //not danger
  }

  /* checking each piece to find check*/
  def check_king(targetRow: Int, targetCol: Int): Int = {
    for (i <- 0 until 7) {
      for (j <- 0 until 7) {
        //check whether white king in danger
        if (check(i, j, targetRow, targetCol) == 1 && !board.isEmptyspot(i, j)) return 1 //white
        else if (check(i, j, targetRow, targetCol) == 0 && !board.isEmptyspot(i, j)) {
          print("gg "+board.board(i)(j))
          println(targetRow + "hi " + targetCol)
          return 0
        } //black in check
      }
    }
    return -1
  }

  def move(activeRow: Int, activeCol: Int, targetRow: Int, targetCol: Int, change: Boolean): Boolean = {
    if (change) {
      if (board.board(activeRow)(activeCol) == ('p') || board.board(activeRow)(activeCol) == ('P'))
        board.pawn.promotion(activeRow, activeCol, targetRow, targetCol)
      board.change(activeRow, activeCol, targetRow, targetCol)
    } else false
    return true
  }
}