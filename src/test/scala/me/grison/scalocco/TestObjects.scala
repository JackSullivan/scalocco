package me.grison.scalocco

/**
 * @author John Sullivan
 */
object TestObjects {




  val multilineCommentRegex = """(?s)/\*(.*)\*/""".r
  val singlelineCommentRegex = """(?m)//(.*)$""".r
  val scaladocRegex = """(?s)/\*\*(.*)\*/""".r

  val multilineScaladoc =
    """/** stuff
      | * multiple lines of stuff
      | * @param this, that
      | * [java.lang.String]
      | */""".stripMargin

  val multilineComment =
    """/* stuff
      | * next line more stuff
      | */""".stripMargin

  val singlelineScaladoc =
    """/** a class [scala.io.Source] */""".stripMargin

  val singlelineComment =
    """// comment on a single line""".stripMargin

}
