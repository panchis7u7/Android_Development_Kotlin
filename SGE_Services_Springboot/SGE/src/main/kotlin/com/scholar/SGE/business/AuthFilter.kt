package com.scholar.SGE.business

import com.scholar.SGE.util.Constants
import io.jsonwebtoken.Jwts
import org.springframework.http.HttpStatus
import org.springframework.web.filter.GenericFilterBean
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthFilter: GenericFilterBean() {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val httpRequest = request as HttpServletRequest
        val httpResponse = response as HttpServletResponse

        val authHeader: String? = httpRequest.getHeader("Authorization")
        if(authHeader != null){
            val authHeaderList = authHeader.split("Bearer ")
            if(authHeaderList.size > 1 && authHeaderList[1] != null){
                val token = authHeaderList[1]
                try {
                    val claims = Jwts.parser().setSigningKey(Constants.API_SECRET_KEY)
                        .parseClaimsJws(token).body
                    httpRequest.setAttribute("id", UUID.fromString(claims.get("idAlumno").toString()))
                } catch (e: Exception){
                    httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Invalid/expired token")
                    return
                }
            } else {
                httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be bearer.")
                return
            }
        } else {
            httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be provided.")
            return
        }
        chain?.doFilter(request,response)
    }
}