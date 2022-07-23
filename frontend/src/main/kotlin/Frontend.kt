import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.div
import kotlinx.html.dom.append
import org.w3c.dom.EventSource
import org.w3c.dom.Node

fun main() {
    window.onload = { document.body?.sayHello() }
    val es = EventSource("http://localhost:8080/sensors/trends")
    es.onmessage = {
        console.log("HELLO !!!!")
        console.log(it.data)
        console.log("GOOD BYE !!!!")
    }

}

fun Node.sayHello() {
    append {
        div {
            +"Hello from JS ++ !!"
        }
    }
}