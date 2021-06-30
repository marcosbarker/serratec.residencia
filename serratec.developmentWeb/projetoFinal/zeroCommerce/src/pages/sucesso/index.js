import React from 'react';
import { useHistory } from 'react-router-dom';
import { makeStyles } from '@material-ui/core/styles';
import Timeline from '@material-ui/lab/Timeline';
import TimelineItem from '@material-ui/lab/TimelineItem';
import TimelineSeparator from '@material-ui/lab/TimelineSeparator';
import TimelineConnector from '@material-ui/lab/TimelineConnector';
import TimelineContent from '@material-ui/lab/TimelineContent';
import TimelineOppositeContent from '@material-ui/lab/TimelineOppositeContent';
import TimelineDot from '@material-ui/lab/TimelineDot';
import AssignmentTurnedInTwoToneIcon from '@material-ui/icons/AssignmentTurnedInTwoTone';
import LaptopMacIcon from '@material-ui/icons/LaptopMac';
import HotelIcon from '@material-ui/icons/Hotel';
import RepeatIcon from '@material-ui/icons/Repeat';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import { FcCheckmark, FcHome } from "react-icons/fc";
import { FiTruck } from "react-icons/fi";

const Sucesso = () => {
    const history = useHistory();

const useStyles = makeStyles((theme) => ({
     paper: {
      padding: '6px 16px',
        },
        secondaryTail: {
        backgroundColor: theme.palette.secondary.main,
        },
      }));
      

    const classes = useStyles();
    
        setTimeout(() => {
          history.push("/")
        }, 10000);

    return (
        <Timeline style={{paddingTop: "30px"}} align="alternate">
        <TimelineItem>
          <TimelineOppositeContent>
            <Typography variant="body2" color="textSecondary">
              
            </Typography>
          </TimelineOppositeContent>
          <TimelineSeparator>
            <TimelineDot>
              <FcCheckmark backgroundColor= "green" />
            </TimelineDot>
            <TimelineConnector />
          </TimelineSeparator>
          <TimelineContent>
            <Paper elevation={3} className={classes.paper}>
              <Typography variant="h6" component="h1">
                Compra Efetuada
              </Typography>
              <Typography>Obrigado Por Comprar Conosco</Typography>
            </Paper>
          </TimelineContent>
        </TimelineItem>
        <TimelineItem>
          <TimelineOppositeContent>
            <Typography variant="body2" color="textSecondary">
              
            </Typography>
          </TimelineOppositeContent>
          <TimelineSeparator>
            <TimelineDot color="primary">
              <LaptopMacIcon />
            </TimelineDot>
            <TimelineConnector />
          </TimelineSeparator>
          <TimelineContent>
            <Paper elevation={3} className={classes.paper}>
              <Typography variant="h6" component="h1">
                Pagamento
              </Typography>
              <Typography>Aguardando Pagamento</Typography>
            </Paper>
          </TimelineContent>
        </TimelineItem>
        <TimelineItem>
          <TimelineSeparator>
            <TimelineDot color="primary" variant="outlined">
              <FcHome />
            </TimelineDot>
            <TimelineConnector className={classes.secondaryTail} />
          </TimelineSeparator>
          <TimelineContent>
            <Paper elevation={3} className={classes.paper}>
              <Typography variant="h6" component="h1">
                Endereço de Entrega
              </Typography>
              <Typography><p>"Avenida Florestal", 0</p>
                
                <p>complemento: "",</p>
                <p>bairro: "Jardins",</p>
                <p>cidade: "Aracruz",</p>
                <p>estado: "ES",</p>
                <p>cep: "29190380"</p></Typography>
            </Paper>
          </TimelineContent>
        </TimelineItem>
        <TimelineItem>
          <TimelineSeparator>
            <TimelineDot color="secondary">
              <FiTruck />
            </TimelineDot>
          </TimelineSeparator>
          <TimelineContent>
            <Paper elevation={3} className={classes.paper}>
              <Typography variant="h6" component="h1">
                Data da Entrega
              </Typography>
              <Typography>Prazo de 5 a 7 dias úteis</Typography>
            </Paper>
          </TimelineContent>
        </TimelineItem>
      </Timeline>
    );
  }
export default Sucesso;