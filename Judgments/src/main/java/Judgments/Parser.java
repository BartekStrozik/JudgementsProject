package Judgments;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Parser {
    public List<Judgment> jsonParser(StringBuilder string){
        String json = dropMetaData(string);
        Gson gson = new Gson();
        Type jsonListType = new TypeToken<List<Judgment>>(){}.getType();
        return gson.fromJson(json,jsonListType);
    }



    public String dropMetaData(StringBuilder stringJson){
        int start = stringJson.indexOf("items") + 7;
        int end = stringJson.indexOf("queryTemplate") -2;
        return stringJson.substring(start,end);
    }

    /*public List<Judgment> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }*/

    /*public List<Judgment> readMessagesArray(JsonReader reader) throws IOException {
        List<Judgment> judgements = new ArrayList<Judgment>();

        reader.beginArray();
        while (reader.hasNext()) {
            judgements.add(readMessage(reader));
        }
        reader.endArray();
        return judgements;
    }*/

    /*public Judgment readMessage(JsonReader reader) throws IOException {
        long id = -1;
        String text = null;
        User user = null;
        List<Double> geo = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                id = reader.nextLong();
            } else if (name.equals("text")) {
                text = reader.nextString();
            } else if (name.equals("geo") && reader.peek() != JsonToken.NULL) {
                geo = readDoublesArray(reader);
            } else if (name.equals("user")) {
                user = readUser(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Judgment(id, text, user, geo);
    }*/

    /*public List<Double> readDoublesArray(JsonReader reader) throws IOException {
        List<Double> doubles = new ArrayList<Double>();

        reader.beginArray();
        while (reader.hasNext()) {
            doubles.add(reader.nextDouble());
        }
        reader.endArray();
        return doubles;
    }

    public User readUser(JsonReader reader) throws IOException {
        String username = null;
        int followersCount = -1;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                username = reader.nextString();
            } else if (name.equals("followers_count")) {
                followersCount = reader.nextInt();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new User(username, followersCount);
    }*/
}
