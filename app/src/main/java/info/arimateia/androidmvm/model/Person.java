package info.arimateia.androidmvm.model;

/**
 * Created by felipets on 8/22/16.
 */

public class Person {

    private String name;
    private String gender;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return url.equals(person.url);

    }

    @Override
    public int hashCode() {
        return url.hashCode();
    }
}
