public void pageRankCalculation(HashMap<String, List<String>> graph, double[] pageRank, int n, int iteration) {
    double[] newPageRank = new double[n];
    double d = 0.85;
    double normalizer = 0;

    for (int i = 0; i < n; i++) {
        List<String> outbound = graph.get(String.valueOf(i));
        if (outbound == null) {
            normalizer = 0;
        } else {
            normalizer = outbound.size();
        }
        newPageRank[i] = 1 - d;

        if (normalizer != 0) {
            for (String url : outbound) {
                newPageRank[i] += d / n * pageRank[Integer.parseInt(url)];
            }
        }
    }

    if (iteration == 0) {
        for (int i = 0; i < n; i++) {
            pageRank[i] = 1.0 / n;
        }
    } else {
        for (int i = 0; i < n; i++) {
            pageRank[i] = newPageRank[i];
        }
    }
}