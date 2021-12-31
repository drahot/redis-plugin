package io.github.drahot.redis_plugin;

import javax.swing.*;

public class RedisConfigForm extends JFrame{

    private static final String FORM_TITLE = "Add a Redis Server";

    private static final String[] PROTOCOL_VERSIONS = {
        "RESP2",
        "RESP3",
    };

    private static final String[] KEY_FILTERS = {
        "auto",
        "utf-8",
        "byte",
    };

    private JTextField txtLabel;
    private JCheckBox chkRedisCluster;
    private JLabel lblLabel;
    private JTextField txtServerUrl;
    private JLabel lblServerUrlFormat;
    private JLabel lblServerUrl;
    private JLabel lblProtocolVersion;
    private JComboBox<String> cmbProtocolVersion;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JTextField txtPassword;
    private JComboBox<String> cmbCharset;
    private JTextField txtKeyFilter;
    private JPanel panelMain;

    public RedisConfigForm() {
        super(FORM_TITLE);
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    private void setupGui() {
        this.addItemsToJComboBox(this.cmbProtocolVersion, PROTOCOL_VERSIONS);
        this.addItemsToJComboBox(this.cmbCharset, KEY_FILTERS);
    }

    private void addItemsToJComboBox(JComboBox<String> comboBox, String... items) {
        for (var item: items) {
            comboBox.addItem(item);
        }
    }

}
