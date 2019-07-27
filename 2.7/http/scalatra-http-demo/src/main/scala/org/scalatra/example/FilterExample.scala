package org.scalatra.example

import org.scalatra._

class FilterExample extends ScalatraFilter {
  get("/filter-example") {
    <p>
      This response was generated by the filter.  By default, the
      <code>notFound</code> action of the filter delegates to the
      next item in the filter chain.  This is ideal for delegating
      to static resources or legacy servlets.
    </p>
  }
}
