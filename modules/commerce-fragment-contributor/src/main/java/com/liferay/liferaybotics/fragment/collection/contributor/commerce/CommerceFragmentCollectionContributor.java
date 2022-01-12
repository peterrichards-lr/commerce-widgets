package com.liferay.liferaybotics.fragment.collection.contributor.commerce;

import com.liferay.fragment.contributor.BaseFragmentCollectionContributor;
import com.liferay.fragment.contributor.FragmentCollectionContributor;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author prich
 */
@Component(property = "fragment.collection.key=LIFERAYBOTICS_COMMERCE_FRAGMENTS", service = FragmentCollectionContributor.class)
public class CommerceFragmentCollectionContributor extends BaseFragmentCollectionContributor {

	@Override
	public String getFragmentCollectionKey() {
		return "LIFERAYBOTICS_COMMERCE_FRAGMENTS";
	}

	@Override
	public ServletContext getServletContext() {
		return _servletContext;
	}

	@Reference(target = "(osgi.web.symbolicname=com.liferay.liferaybotics.fragment.collection.contributor.commerce)")
	private ServletContext _servletContext;

}