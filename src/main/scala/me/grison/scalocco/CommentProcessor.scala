package me.grison.scalocco

import scala.io.Source
import scala.util.parsing.combinator.RegexParsers

object CommentParser extends RegexParsers {

  val any:Parser[String] = "(?s)(.+?)(?=//|/\\*|\\z)".r("contents")
  val stringDelim:Parser[String] = "\"|\"\"\"".r
  val string = stringDelim ~ any ~ stringDelim ^^ {t =>  t._1._1 + t._1._2 + t._2}

  val multilineCommentRegex:Parser[String] = """(?s)/\*(.*?)\*/""".r("commentString")
  val singlelineCommentRegex:Parser[String] = """(?m)//(.*)$""".r("commentString")
  val scaladocRegex:Parser[String] = """(?s)/\*\*(.*?)\*/""".r("commentString")

  val eof:Parser[String] = """\z""".r
  val comment = scaladocRegex | multilineCommentRegex | singlelineCommentRegex
  val code = any <~ guard(comment | eof)

  //val multilineCommentText:Parser[String] = beginMultilineCommentMarker ~> text <~ endMultilineCommentMarker
  //val singlelineComment:Parser[String] = singleLineCommentMarker ~> singleLineCommentText
  //val comment = singlelineCommentText | multilineCommentText
  //val code = not(comment)

  //val doc = (code | comment).*
  val doc = (code | comment).+

  def main(args:Array[String]) {
    val sourceText = Source.fromFile(args(0)).mkString
    //println(sourceText)
    val res = parseAll((comment.* ~ code).+ <~ eof, sourceText)
    //val res = parseAll(doc, sourceText)
    println(res)
  }
}

