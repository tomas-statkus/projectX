import org.jsoup.Jsoup

fun main(){
    scraperTwo().runScraper2()
    //scraperOne().runScraper().forEach { println(it) }
}


class scraperTwo {
    fun runScraper2(): ArrayList<HashMap<String, String>> {
        // this object connects to the website
        val jsoupConnection = Jsoup.connect("https://www.advratings.com/europe/top-banks-in-spain")

        //this catches all the h2 tags in the body of the loaded page in a list "getElementsByTag"
        val h4Tags = jsoupConnection.get().body().getElementsByClass("content")[0].getElementsByTag("li")

        //println(h4Tags)

        // the main array list of hashmaps
        val arrayOfMap = ArrayList<HashMap<String,String>>()

        // loop through the list of h1tags
        h4Tags.forEach {
            //map to collect information
            val map = HashMap<String,String>()
            //insert information to the hashmaps
            map["hello"] = it.toString()
            val href = it.getElementsByTag ("a").attr("href")
            val title = it.getElementsByTag ("a").attr("title")

            println("$title")

            //insert the map into a list of hashmaps
            arrayOfMap.add(map)
        }
        return arrayOfMap
    }
}