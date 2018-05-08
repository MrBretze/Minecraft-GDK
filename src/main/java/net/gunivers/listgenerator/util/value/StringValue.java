package net.gunivers.listgenerator.util.value;

public class StringValue extends IValue<String>
{
    private String val;

    public StringValue(String val)
    {
        set(val);
    }

    @Override
    public void set(String type)
    {
        this.val = type;
    }

    @Override
    public String get()
    {
        return val;
    }
}