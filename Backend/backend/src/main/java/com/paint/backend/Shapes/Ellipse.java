package com.paint.backend.Shapes;

import org.json.JSONObject;

import java.util.Objects;


public class Ellipse extends Shape {
    private float x, y, radiusX, radiusY, strokeWidth, alpha, rotateAngle;
    private String stroke, fill;

    public Ellipse() {}

    @Override
    public void update(JSONObject jsonUpdate, String state){
        if(Objects.equals(state, "new")){ UndoUpdate.push(jsonUpdate); }
        else{ RedoUpdate.push(jsonUpdate); }

        switch(jsonUpdate.getString("attrs")){
            case "move"-> {
                this.x = (((JSONObject)(jsonUpdate.get(state))).getFloat("x"));
                this.y = (((JSONObject)(jsonUpdate.get(state))).getFloat("y"));
            }
            case "radiusX" -> this.radiusX = jsonUpdate.getFloat(state);
            case "radiusY" -> this.radiusY = jsonUpdate.getFloat(state);
            case "strokeWidth" -> this.strokeWidth = jsonUpdate.getFloat(state);
            case "alpha" -> this.alpha = jsonUpdate.getFloat(state);
            case "rotateAngle" -> this.rotateAngle = jsonUpdate.getFloat(state);
            case "stroke"-> this.stroke = jsonUpdate.getString(state);
            case "fill"-> this.fill = jsonUpdate.getString(state);
            case "Type"-> this.Type = jsonUpdate.getString(state);
        }
    }

    @Override
    public String draw() {
        return "Ellipse {\n" +
                "\tx = " + x + ",\n" +
                "\ty = " + y + ",\n" +
                "\tID = " + ID + ",\n" +
                "\tstrokeWidth = " + strokeWidth + ",\n" +
                "\talpha = " + alpha + ",\n" +
                "\trotateAngle = " + rotateAngle + ",\n" +
                "\tstroke = '" + stroke + '\'' + ",\n" +
                "\tfill = '" + fill + '\'' + ",\n" +
                "\tType = '" + Type + '\'' + ",\n" +
                "\tradiusX = " + radiusX + ",\n" +
                "\tradiusY = " + radiusY + ",\n" +
                '}';
    }
}
