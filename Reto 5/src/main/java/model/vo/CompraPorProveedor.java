package model.vo;

public class CompraPorProveedor {
    //Su codigo
    private Integer idCompra;
    private String Proveedor;
    private String Constructora;
    private String BancoVinculado;
    private String Ciudad;

    public CompraPorProveedor(){};

    public CompraPorProveedor (Integer idCompra, String Proveedor, String Constructora, String BancoVinculado, String Ciudad) {
        this.idCompra = idCompra;
        this.Proveedor = Proveedor;
        this.Constructora = Constructora;
        this.BancoVinculado = BancoVinculado;
        this.Ciudad = Ciudad;
    }

    public Integer getIdCompra() {        return idCompra;    }
    public void setIdCompra(Integer idCompra) {        this.idCompra = idCompra;    }

    public String getProveedor() {        return Proveedor;    }
    public void setProveedor(String proveedor) {        Proveedor = proveedor;    }

    public String getConstructora() {        return Constructora;    }
    public void setConstructora(String constructora) {        Constructora = constructora;    }

    public String getBancoVinculado() {        return BancoVinculado;    }
    public void setBancoVinculado(String bancoVinculado) {        BancoVinculado = bancoVinculado;    }

    public String getCiudad() {        return Ciudad;    }
    public void setCiudad(String ciudad) {        Ciudad = ciudad;    }
    
    
}
