import org.jsoup.Jsoup
import java.io.File
import java.nio.file.Files
import java.nio.file.Path

fun main(){
    ScraperOne().runScraper()
    //scraperOne().runScraper().forEach { println(it) }
}


class ScraperOne {
    fun runScraper() {
        // this object connects to the website


        val url = "https://www.baltic-legal.com/banking-in-lithuania-list-of-banks-eng.htm"
        val jsoupConnection = Jsoup.connect(url)

        //this catches all the h2 tags in the body of the loaded page in a list "getElementsByTag"
        val h4Tags = jsoupConnection.get().body().getElementsByClass("content")[0].getElementsByTag("li")

        //println(h4Tags)

        // the main array list of hashmaps
        val arrayOfMap = ArrayList<HashMap<String, String>>()

        // loop through the list of h1 tags
        h4Tags.forEach {
            //map to collect information
            val map = HashMap<String, String>()
            //insert information to the hashmaps

            val href = it.getElementsByTag("a").attr("href")
            val title = it.getElementsByTag("a").attr("title")

            map["hello"] = title
            //insert the map into a list of hashmaps
            arrayOfMap.add(map)
        }


        File("somefile.txt").printWriter().use { out ->
            arrayOfMap.forEach {
                out.println(it["hello"])
            }
        }

    }}