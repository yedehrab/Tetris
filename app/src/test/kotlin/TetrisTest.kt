import com.om.tetris.shapes.*
import org.junit.Test
import kotlin.test.assertTrue

class TetrisTest {

  @Test
  fun testCreateBoxShape() {
    val box = Box()

    val grid: Array<IntArray> = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(0, 0)
    )

    val expectedGrid: Array<IntArray> = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(1, 1)
    )

//    assertTrue(
//        twoDimenArrayEquals(expectedGrid, TetrisBlock.addShapeToGrid(box.grid, grid, Pair(1, 1))))

    val newGrid = TetrisBlock.addShapeToGrid(box.grid, grid, Pair(0, 0))

    newGrid.forEachIndexed { index, ints ->
      var row = ""

      ints.forEach {
        row += "$it "
      }

      System.out.println(row)
    }
  }

  @Test
  fun testCreateGliderShape() {
    val glider = Glider(Pair(1, 2))

    val grid: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0)
    )

    val expectedGrid: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0),
        intArrayOf(1, 1, 1, 0),
        intArrayOf(0, 0, 0, 0)
    )

//    assertTrue(twoDimenArrayEquals(expectedGrid, glider.addToGrid(grid)))
  }

  @Test
  fun testCreateTShape() {
    val tShape = TBlock(Pair(1, 1))

    val grid: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0)
    )

    val expectedGrid: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 1, 1, 1),
        intArrayOf(0, 0, 1, 0),
        intArrayOf(0, 0, 0, 0)
    )

//    assertTrue(twoDimenArrayEquals(expectedGrid, tShape.addToGrid(grid)))
  }

  @Test
  fun testCreateZShape() {
    val zShape = ZBlock(Pair(1, 1))

    val grid: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0)
    )

    val expectedGrid: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 1, 1, 0),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0)
    )

//    assertTrue(twoDimenArrayEquals(expectedGrid, zShape.addToGrid(grid)))
  }

  @Test
  fun testCreateStickShape() {
    val stick = Stick(Pair(0, 1))

    val grid: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0)
    )

    val expectedGrid: Array<IntArray> = arrayOf(
        intArrayOf(0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0)
    )

//    assertTrue(twoDimenArrayEquals(expectedGrid, stick.addToGrid(grid)))
  }

  @Test
  fun testClearGrid() {
    val grid: Array<IntArray> = arrayOf(
        intArrayOf(0, 1, 1, 0),
        intArrayOf(0, 1, 1, 0),
        intArrayOf(1, 1, 1, 0),
        intArrayOf(0, 1, 0, 1)
    )

    val expectedGrid: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0)
    )

    assertTrue(twoDimenArrayEquals(expectedGrid, TetrisBlock.clearGrid(grid)))
  }

  private fun twoDimenArrayEquals(first: Array<IntArray>, second: Array<IntArray>): Boolean {
    first.forEachIndexed { rowIndex, ints ->
      ints.forEachIndexed { columnIndex, _ ->
        if (first[rowIndex][columnIndex] != second[rowIndex][columnIndex])
          return false
      }
    }

    return true
  }
}