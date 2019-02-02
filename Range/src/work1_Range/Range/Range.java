package work1_Range.Range;

public class Range {
    private double from;
    private double to;


    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getFrom() {
        return from;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double inputNumber) {
        return (inputNumber >= from) && (inputNumber <= to);
    }


    public Range getIntersection(Range range2) {
        double from2 = range2.getFrom();
        double to2 = range2.getTo();
        double from1 = this.getFrom();
        double to1 = this.getTo();
        if ((from2 > from1 && from2 < to1) || (from2 < from1 && from2 > to1)) {
            double intersectionFrom = Math.max(from2, from1);
            double intersectionTo = Math.min(to2, to1);
            return new Range(intersectionFrom, intersectionTo);
        }
        return null;
    }

    public Range[] getUnion(Range range2) {
        double from2 = range2.getFrom();
        double to2 = range2.getTo();
        double from1 = this.getFrom();
        double to1 = this.getTo();
        if (from2 <= Math.min(to2, to1) && from1 <= Math.min(to2, to1)) {
            return new Range[]{new Range(Math.min(from2, from1), Math.max(to2, to1))};
        } else {
            return new Range[]{new Range(from1, to1), new Range(from2, to2)};
        }
    }

    public Range[] getDifference(Range range2) {
        double from2 = range2.getFrom();
        double to2 = range2.getTo();
        double from1 = this.getFrom();
        double to1 = this.getTo();
        if (from1 < from2) {
            if (from2 < to1) {
                if (to2 >= to1) {
                    return new Range[]{new Range(from1, from2)};
                } else {
                    return new Range[]{new Range(from1, from2), new Range(to2, to1)};
                }
            } else {
                return new Range[]{new Range(from1, to1)};
            }
        }
        if (from1 >= from2) {
            if (to2 > from1) {
                if (to2 < to1) {
                    return new Range[]{new Range(to2, to1)};
                }
            } else {
                return new Range[]{new Range(from1, to1)};
            }
        }
        return new Range[]{};
    }
}
