package sk.tuke.kpi.kp.ninemensmorris;

public class Mill {
    public boolean check(int i, Field field){
        Position position = field.getPositions().get(i);
        if (position==null)
            return false;
        Position right = position.getRight();
        Position farRight = null;
        if(right!=null)
            farRight = right.getRight();
        Position left = position.getLeft();
        Position farLeft=null;
        if (left!=null)
            farLeft= left.getLeft();
        Position up = position.getUp();
        Position farUp = null;
        if(up!=null)
            farUp = up.getUp();
        Position down = position.getDown();
        Position farDown = null;
        if(down!=null)
            farDown = down.getDown();

        if(right!=null && left!=null)
            if(position.getColor()==right.getColor()
                    && position.getColor()==left.getColor())
                return true;
        if(down!=null && up!=null)
            if(position.getColor()==up.getColor()
                    && position.getColor()==down.getColor())
                return true;
        if(down!=null && farDown!=null)
            if(position.getColor()==down.getColor()
                    && position.getColor()==farDown.getColor())
                return true;
        if(up!=null && farUp!=null)
            if(position.getColor()==up.getColor()
                    && position.getColor()==farUp.getColor())
                return true;
        if(right!=null && farRight!=null)
            if(position.getColor()==right.getColor()
                    && position.getColor()==farRight.getColor())
                return true;
        if(left!=null && farLeft!=null)
            if(position.getColor()==left.getColor()
                    && position.getColor()==farLeft.getColor())
                return true;
        return false;
    }
}
