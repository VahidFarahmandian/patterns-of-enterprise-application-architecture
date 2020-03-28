package WebPresentationPatterns.PageController.ServletControllerAndJSPView;

import java.io.IOException;

public class ArtistController extends ActionServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        Artist artist = Artist.findNamed(request.getParameter("name"));

        if (artist == null) {
            forward("/MissingArtistError.jsp", request, response);
        } else {
            request.setAttribute("helper", new ArtistHelper(artist));
            forward("/artist.jsp", request, response);
        }
    }
}