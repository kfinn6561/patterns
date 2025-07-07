package org.example.pipeline;

public abstract class Stage {
    private Stage next;

    public Data process(Data data){
        Data processedData = handle(data);
        if (next==null){
            return processedData;
        }else {
            return next.process(processedData);
        }
    }

    protected abstract Data handle(Data data);

    public static Stage CreateChain(Stage first, Stage... chain){
        Stage head = first;
        for (Stage stage : chain){
            head.next = stage;
            head = stage;
        }
        return first;
    }
}
