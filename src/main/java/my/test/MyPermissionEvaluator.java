package my.test;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;


public class MyPermissionEvaluator implements PermissionEvaluator {
	
	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		System.out.println("hasPermission() " + authentication + " target: " + targetDomainObject + " perm:" + permission);
		return true;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
		System.out.println("hasPermission() " + authentication + " targetId: " 
				+ targetId + " targetType:" + targetType + " perm:" + permission);
		return true;
	}

}
