package sub2;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/welcome.do", "/greeting.do"})
public class FilterC extends HttpFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 필터링 수행
		System.out.println("FilterC doFilter...");
		
		// 다음 필터 이동(최종 필터는 서블릿)
		chain.doFilter(request, response);
	}

}
