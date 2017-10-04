package webServlet.test;

import java.io.Serializable;

/**
 * Describe class CustomerBean here.
 *
 *
 * Created: Sat Sep 30 22:38:42 2017
 *
 * @author <a href="mailto:root@localhost.localdomain">root</a>
 * @version 1.0
 */
public class CustomerBean  implements Serializable{

    private String  name;
    private String  email;
    private String  phone;

    /**
     * Creates a new <code>CustomerBean</code> instance.
     *
     */
    public CustomerBean(){
	this.name = "";
	this.email = "";
	this.phone = "";
    }

    /**
     * Gets the value of name
     *
     * @return the value of name
     */
    public final String getName() {
	return this.name;
    }

    /**
     * Sets the value of name
     *
     * @param argName Value to assign to this.name
     */
    public final void setName(final String argName) {
	this.name = argName;
    }

    /**
     * Gets the value of email
     *
     * @return the value of email
     */
    public final String getEmail() {
	return this.email;
    }

    /**
     * Sets the value of email
     *
     * @param argEmail Value to assign to this.email
     */
    public final void setEmail(final String argEmail) {
	this.email = argEmail;
    }

    /**
     * Gets the value of phone
     *
     * @return the value of phone
     */
    public final String getPhone() {
	return this.phone;
    }

    /**
     * Sets the value of phone
     *
     * @param argPhone Value to assign to this.phone
     */
    public final void setPhone(final String argPhone) {
	this.phone = argPhone;
    }
}
