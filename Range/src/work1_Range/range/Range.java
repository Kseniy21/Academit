package work1_Range.range;

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

    public Range getIntersection(Range range) {
        double intersectionFrom = Math.max(range.from, this.from);
        double intersectionTo = Math.min(range.to, to);

        if (intersectionFrom < intersectionTo) {
            return new Range(intersectionFrom, intersectionTo);
        }
        return null;
    }

    public Range[] getUnion(Range range) {
        if (this.from > range.to) {
            return new Range[]{new Range(range.from, range.to), new Range(this.from, this.to)};
        } else if (range.from > this.to) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        } else {
            return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
        }
    }

    public Range[] getDifference(Range range) {
        double from2 = range.from;
        double to2 = range.to;
        double from1 = this.from;
        double to1 = this.to;

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
