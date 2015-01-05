package me.grison.scalocco

/**
 * @author John Sullivan
 */
object TestObjects {




  val multilineCommentRegex = """(?s)/\*(.*?)\*/""".r("commentString")
  val singlelineCommentRegex = """(?m)//(.*)$""".r("commentString")
  val scaladocRegex = """(?s)/\*\*(.*?)\*/""".r("commentString")

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


  val complexExample =
    """
      |//Scalocco
      |//---------------
      |object Scalocco extends Markdown {
      |    // This value is used to differentiate normal comments from scaladoc style.
      |    val scaladoc = UUID.randomUUID().toString
      |
      |    //ScalaDoc Parsing
      |    //---------------
      |    object ScalaDocParser {
      |        /**
      |         * Abstract class representing a Scaladoc item.
      |         * @param tpl the Mustache template to be used to render the Scaladoc.
      |         */
      |        abstract class DocItem(tpl: Mustache) {
      |            // Render this Scaladoc item
      |            def render = tpl.render(this)
      |        }
      |
      |        /**
      |         * Scaladoc item representing the documentation itself
      |         * @param doc the global scaladoc documentation.
      |         */
      |        case class Doc(doc: String)
      |            extends DocItem("<tr><td colspan='2' class='doc'>{{{doc}}}</td></tr>".mustache)
      |
      |        /**
      |         * Scaladoc item representing a param as described in the ScalaDoc
      |         * @param param the parameter name.
      |         * @param doc the documentation associated to this param.
      |         */
      |        case class Param(param: String, doc: String)
      |            extends DocItem("<tr><td class='param'><tt>{{param}}</tt></td><td class='param-doc'>{{{doc}}}</td></tr>".mustache)
      |    }
      |}
    """.stripMargin
}
