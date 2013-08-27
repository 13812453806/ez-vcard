package ezvcard;

import java.util.Collection;

import ezvcard.util.CaseClasses;

/*
 Copyright (c) 2013, Michael Angstadt
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met: 

 1. Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer. 
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution. 

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 The views and conclusions contained in the software and documentation are those
 of the authors and should not be interpreted as representing official policies, 
 either expressed or implied, of the FreeBSD Project.
 */

/**
 * Represents a VALUE parameter.
 * @author Michael Angstadt
 */
public class VCardDataType {
	private static final CaseClasses<VCardDataType, String> enums = new CaseClasses<VCardDataType, String>(VCardDataType.class) {
		@Override
		protected VCardDataType create(String value) {
			return new VCardDataType(value);
		}

		@Override
		protected boolean matches(VCardDataType object, String value) {
			return object.name.equalsIgnoreCase(value);
		}
	};

	/**
	 * <b>Supported versions:</b> <code>2.1 (p.18-9)</code>
	 */
	public static final VCardDataType URL = new VCardDataType("url");

	/**
	 * <b>Supported versions:</b> <code>2.1 (p.8-9)</code>
	 */
	public static final VCardDataType CONTENT_ID = new VCardDataType("content-id");

	/**
	 * <b>Supported versions:</b> <code>3.0</code>
	 */
	public static final VCardDataType BINARY = new VCardDataType("binary");

	/**
	 * <b>Supported versions:</b> <code>3.0, 4.0</code>
	 */
	public static final VCardDataType URI = new VCardDataType("uri");

	/**
	 * <b>Supported versions:</b> <code>3.0, 4.0</code>
	 */
	public static final VCardDataType TEXT = new VCardDataType("text");

	/**
	 * <b>Supported versions:</b> <code>3.0, 4.0</code>
	 */
	public static final VCardDataType DATE = new VCardDataType("date");

	/**
	 * <b>Supported versions:</b> <code>3.0, 4.0</code>
	 */
	public static final VCardDataType TIME = new VCardDataType("time");

	/**
	 * <b>Supported versions:</b> <code>3.0, 4.0</code>
	 */
	public static final VCardDataType DATE_TIME = new VCardDataType("date-time");

	/**
	 * <b>Supported versions:</b> <code>4.0</code>
	 */
	public static final VCardDataType DATE_AND_OR_TIME = new VCardDataType("date-and-or-time");

	/**
	 * <b>Supported versions:</b> <code>4.0</code>
	 */
	public static final VCardDataType TIMESTAMP = new VCardDataType("timestamp");

	/**
	 * <b>Supported versions:</b> <code>4.0</code>
	 */
	public static final VCardDataType BOOLEAN = new VCardDataType("boolean");

	/**
	 * <b>Supported versions:</b> <code>4.0</code>
	 */
	public static final VCardDataType INTEGER = new VCardDataType("integer");

	/**
	 * <b>Supported versions:</b> <code>4.0</code>
	 */
	public static final VCardDataType FLOAT = new VCardDataType("float");

	/**
	 * <b>Supported versions:</b> <code>4.0</code>
	 */
	public static final VCardDataType UTC_OFFSET = new VCardDataType("utc-offset");

	/**
	 * <b>Supported versions:</b> <code>4.0</code>
	 */
	public static final VCardDataType LANGUAGE_TAG = new VCardDataType("language-tag");

	private final String name;

	private VCardDataType(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the data type.
	 * @return the name of the data type (e.g. "uri")
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * Searches for a parameter value that is defined as a static constant in
	 * this class.
	 * @param value the parameter value
	 * @return the object or null if not found
	 */
	public static VCardDataType find(String value) {
		return enums.find(value);
	}

	/**
	 * Searches for a parameter value and creates one if it cannot be found. All
	 * objects are guaranteed to be unique, so they can be compared with
	 * <code>==</code> equality.
	 * @param value the parameter value
	 * @return the object
	 */
	public static VCardDataType get(String value) {
		return enums.get(value);
	}

	/**
	 * Gets all of the parameter values that are defined as static constants in
	 * this class.
	 * @return the parameter values
	 */
	public static Collection<VCardDataType> all() {
		return enums.all();
	}
}