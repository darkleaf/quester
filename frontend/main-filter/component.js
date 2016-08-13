import React, {Component} from "react"

export default class MainFilter extends Component {
  render() {
    return (
      <div>
        <div>{this.props.title}</div>
        {/*TODO pass as children*/}
        <div>Категрия Участники Дата Цена Найти</div>

      </div>
    )
  }
}

MainFilter.propTypes = {
  title: React.PropTypes.string.isRequired
};
