package br.com.joaofra.jsfhtml5.bean;

import br.com.joaofra.jsfhtml5.entidade.UsuarioEntidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.lang3.StringUtils;



/**
 *
 * @author joaofra
 */
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{
    
    @PostConstruct
    public void init(){
        if (usuario == null)
            usuario = new UsuarioEntidade();
        
        if (listaUsuarios == null)
            listaUsuarios = new ArrayList<UsuarioEntidade>();
    }
    
    private UsuarioEntidade usuario;
    
    private List<UsuarioEntidade> listaUsuarios = new ArrayList<UsuarioEntidade>();

    public UsuarioEntidade getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntidade usuario) {
        this.usuario = usuario;
    }

    public List<UsuarioEntidade> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<UsuarioEntidade> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public String doLogin(){
        
        if(StringUtils.isNotBlank(usuario.getSenha()) && StringUtils.isNotBlank(usuario.getUsuario())){
            apagaCampos();
            return "sucesso";
        } else {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário ou senha inválidos", "");
            FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
            return "";
        }
        
    }
   
    public void apagaCampos(){
        usuario.setUsuario("");
        usuario.setSenha("");
    }
    
    public void adicionaUsuario(){
        
        if (listaUsuarios == null)
            listaUsuarios = new ArrayList<UsuarioEntidade>();
        
        listaUsuarios.add(usuario);
        usuario = new UsuarioEntidade();
    }
    
}
