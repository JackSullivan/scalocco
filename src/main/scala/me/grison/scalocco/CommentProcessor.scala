package me.grison.scalocco

import scala.io.Source
import scala.util.parsing.combinator.RegexParsers

object CommentParser extends RegexParsers {

  override protected val whiteSpace = " |\t".r

  val beginMultilineCommentMarker:Parser[String] = """/\*\*?""".r
  val continueMultilineComment:Parser[String] = """\*""".r
  val endMultilineCommentMarker:Parser[String] = """\*/""".r
  val singleLineCommentMarker:Parser[String] = """//""".r
  val singleLineCommentText:Parser[String] = "(.*)(?=(\n|$))".r
  val text:Parser[String] = "(.*)(?=\\*/)".r
  val newline:Parser[String] = "\n"

  val multilineCommentText:Parser[String] = beginMultilineCommentMarker ~> text <~ endMultilineCommentMarker
  val singlelineComment:Parser[String] = singleLineCommentMarker ~> singleLineCommentText
  //val comment = singlelineCommentText | multilineCommentText
  //val code = not(comment)

  //val doc = (code | comment).*

  def main(args:Array[String]) {
    val sourceText = Source.fromFile(args(0)).mkString("\n")

    //val res = parseAll(doc, sourceText)
    println(res)
  }
}

