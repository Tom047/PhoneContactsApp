package reposiitories;

import data.interfaces.IDB;
import entities.Contact;
import reposiitories.interfaces.IContactsRepository;

import java.sql.*;
import java.util.ArrayList;

public class ContactsRepository implements IContactsRepository {
    private final IDB db;

    public ContactsRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createContact(Contact contact) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO contacts(name,phone,email) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, contact.getName());
            st.setString(2, contact.getPhone());
            st.setString(3, contact.getEmail());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean deleteContact(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM contacts WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public boolean editContactName(int id, String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE contacts SET name = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, id);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public boolean editContactPhone(int id, String phone) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE contacts SET phone = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, phone);
            st.setInt(2, id);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean editContact(int id, String param, String newValue) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE contacts SET " + param + " = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, newValue);
            st.setInt(2, id);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public ArrayList<Contact> findContact(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,phone,email FROM contacts WHERE name LIKE ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            ArrayList<Contact> coincidences = new ArrayList<>();
            while (rs.next()) {
                Contact contact = new Contact(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"));
                coincidences.add(contact);
            }
            return coincidences;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Contact getContact(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,phone,email FROM contacts WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Contact contact = new Contact(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"));
                return contact;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ArrayList<Contact> getAllContacts() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,phone,email FROM contacts";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            ArrayList<Contact> contacts = new ArrayList<>();
            while (rs.next()) {
                Contact contact = new Contact(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"));
                contacts.add(contact);
            }
            return contacts;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
