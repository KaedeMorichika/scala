package example

object Main {
  def main(args: Array[String]): Unit = {
    var location = new Location(35.1234, 135.1234)
    println(location.getCoordinate()(0) + ", " + location.getCoordinate()(1))
  }
}

class Location(latitude: Double, longitude: Double) {

  def getCoordinate() : Array[Double] = {
    Array(latitude, longitude)
  }
}

class Route() {
  private var route = Array[Location]
}