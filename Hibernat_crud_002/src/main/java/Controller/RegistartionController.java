package Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.User;

@WebServlet("/reg")
@MultipartConfig
public class RegistartionController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		Part file = req.getPart("file");

		String filename = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setPass(pass);
		u.setImg(filename);

		String basepath = req.getServletContext().getRealPath("") + File.separator + "img";

		File f = new File(basepath);
		if (!f.exists()) {
			f.mkdir();

		}

		file.write(basepath + File.separator + filename);

		UserDao dao = new UserDao();
		int i = 0;

		if (id.equals("")) {
			i = dao.addorupdateuser(u);

			if (i > 0) {
				req.setAttribute("msg", "Registartion Successfully");
				req.getRequestDispatcher("index.jsp").forward(req, resp);

			}
		} else {
			u.setId(Integer.parseInt(id));
			i = dao.addorupdateuser(u);
			if (i > 0) {
				req.setAttribute("msg", "Update Successfully");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}

		}

	}

}
