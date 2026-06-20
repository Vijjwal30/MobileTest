package com.androidfx.utilities;

import javafx.animation.Interpolator;

public class CubicBezier extends Interpolator {
    private final double x1, y1, x2, y2;

    public CubicBezier(double x1, double y1, double x2, double y2) {
        // Enforce the standard 0 to 1 rule only for X to prevent temporal folding
        if (x1 < 0 || x1 > 1 || x2 < 0 || x2 > 1) {
            throw new IllegalArgumentException("X coordinates must be in range [0, 1]");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected double curve(double t) {
        // Step 1: Solve for the internal cubic time parameter using Newton-Raphson
        double bezierT = getBezierTForX(t);

        // Step 2: Compute and return the true vertical Y position (which allows overshooting)
        return sampleBezierY(bezierT);
    }

    private double sampleBezierX(double t) {
        return 3 * (1 - t) * (1 - t) * t * x1 + 3 * (1 - t) * t * t * x2 + t * t * t;
    }

    private double sampleBezierY(double t) {
        return 3 * (1 - t) * (1 - t) * t * y1 + 3 * (1 - t) * t * t * y2 + t * t * t;
    }

    private double getXDerivative(double t) {
        return 3 * (1 - 3 * x2 + 3 * x1) * t * t + 6 * (x2 - 2 * x1) * t + 3 * x1;
    }

    private double getBezierTForX(double targetX) {
        double t = targetX;
        // Run 8 iterations of Newton-Raphson optimization for high accuracy
        for (int i = 0; i < 8; i++) {
            double currentX = sampleBezierX(t) - targetX;
            double derivative = getXDerivative(t);
            if (Math.abs(derivative) < 1e-6) break;
            t -= currentX / derivative;
        }
        return Math.max(0, Math.min(1, t)); // Ensure the solved 't' boundaries are safe
    }
}

