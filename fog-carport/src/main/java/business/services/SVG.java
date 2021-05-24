package business.services;

public class SVG
{
    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private final String headerTemplate = "<svg height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" "+
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:#000000; fill: #ffffff\" />";
    private final String lineTemplate = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000; stroke-dasharray:10,10\" />";
    private final String lengthTextTemplate ="<text x=\"%d\" y=\"%d\">\"%d\" cm </text>";
    private final String widthTextTemplate ="<text x=\"%d\" y = \"%d\" transform=\"rotate=-90\">\"%d\" cm </text>";

    public SVG(int x, int y, String viewBox, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y ));
    }

    public void addRect(int x, int y, int height, int width)
    {
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    public void addLine(int x1, int y1, int x2, int y2)
    {
        svg.append(String.format(lineTemplate, x1, y1, x2, y2));
    }

    public void lengthTextTemplate(int x, int y, int value)
    {
        svg.append(String.format(lengthTextTemplate, x, y, value));
    }

    public void widthTextTemplate(int x, int y, int l)
    {
        svg.append(String.format(widthTextTemplate, x, y, l));
    }

    @Override
    public String toString()
    {
        return svg.toString() + "</svg>" ;
    }
}